
var xhrlp = '';
$(document).ready(function() {
    if (!window.console) window.console = {};
    if (!window.console.log) window.console.log = function() {};

    $("#message").select();
    {% if user.is_authenticated %}
    updater.start();
    updater.poll();
    {% endif %}
});

function getCookie(name) {
    var r = document.cookie.match("\\b" + name + "=([^;]*)\\b");
    return r ? r[1] : undefined;
}

jQuery.postJSON = function(url, args, callback) {
    $.ajax({url: url, dataType: "json", type: "POST", cache: false,
	    success: function(response) {
	if (callback) callback(response);
    }, error: function(response) {
	console.log("ERROR:", response);
    }});
};

jQuery.fn.formToDict = function() {
    var fields = this.serializeArray();
    var json = {}
    for (var i = 0; i < fields.length; i++) {
	json[fields[i].name] = fields[i].value;
    }
    if (json.next) delete json.next;
    return json;
};

jQuery.fn.disable = function() {
    this.enable(false);
    return this;
};

jQuery.fn.enable = function(opt_enable) {
    if (arguments.length && !opt_enable) {
        this.attr("disabled", "disabled");
    } else {
        this.removeAttr("disabled");
    }
    return this;
};

var loads = 0;
var updater = {
    errorSleepTime: 5000,
    started: false,
    last_ids: new Object(),
    start: function() {
	    console.log("Initial fetching of all notifications.");
	    {% for peer in user.userprofile.peers.all %}
	    updater.last_ids["{{ peer.pk }}"] = null;
	    $.ajax({url: "{% url 'fetch-existing'  peer.pk %}", type: "POST", dataType: "json", cache:false,
			    success: updater.onFetchExisting,
			    error: updater.onError});
	    {% endfor %}
    },
    poll: function() {
    	{% if user.is_authenticated %}
    	if (oTable) {
    		oTable.fnReloadAjax(refreshUrl);
	}
    	timeout = {{timeout}};
        {% for peer in user.userprofile.peers.all %}
        console.log("Polling new notifications from", updater.last_ids["{{ peer.pk }}"], "peerid {{ peer.pk }}");
        $.ajax({url: "{% url 'fetch-updates'  peer.pk 'PLACEHOLDER' %}".replace("PLACEHOLDER", updater.last_ids["{{ peer.pk }}"]), type: "POST", dataType: "json", cache:false,
    		success: updater.onSuccess,
    		timeout: timeout,
    		error: updater.onError});
        {% endfor %}
    	{% endif %}
    },
    onSuccess: function(response) {
	try {
	    updater.newMessages(response);
	} catch (e) {
	    updater.onError();
	    return;
	}
	window.setTimeout(updater.poll, updater.errorSleepTime);
    },

    onFetchExisting: function(response) {
    	try {
    	    updater.existingMessages(response);
    	    updater.started = true;
    	} catch (e) {
    	    updater.onError();
    	    return;
    	}
        },

    onError: function(response, text) {
	     if (text == 'timeout'){
		     if (oTable) {
			     oTable.fnReloadAjax(refreshUrl);
		     }
	     }
	     if (updater.started == false) {
		     window.setTimeout(updater.start, updater.errorSleepTime);
	     } else {
		     window.setTimeout(updater.poll, updater.errorSleepTime);
	     }
    },

    newMessages: function(response) {
	if (!response.messages) return;
	if (response.messages.length == 0){
		return true;
	}
	var messages = response.messages;
	var peerid = messages[messages.length - 1]["peerid"];
	var msgid = messages[messages.length - 1]["id"];
	updater.last_ids[peerid] = msgid;
	console.log(messages.length, "new messages, last_id:", msgid, "peerid", peerid);

	for (var i = 0; i < messages.length; i++) {
	    updater.showMessage(messages[i]);
	}
	$("#hid_mid").val('UPDATED');
	if (oTable) {
		oTable.fnReloadAjax(refreshUrl);
	}
    },

    existingMessages: function(response) {
    	if (!response.messages) return;
    	if (response.messages.length == 0){
    		return true;
    	}
	$("#inbox").empty();
    	var messages = response.messages;
	var peerid = messages[messages.length - 1]["peerid"];
	var msgid = messages[messages.length - 1]["id"];
	updater.last_ids[peerid] = msgid
	console.log("got", messages.length, "messages with last_id", msgid);
    	for (var i = 0; i < messages.length; i++) {
    	    updater.showMessage(messages[i]);
    	}
        },

    showMessage: function(message) {
	var existing = $("#m" + message.id);
	if (existing.length > 0) return;
	var username = message.body.split("]")[0].replace("[","");
	var mbody = message.body.replace("["+username+"] ","");
	var htmlnode = '<li class="left clearfix">\
                                    <div class="chat-body clearfix" style="margin-left: 0px;"> \
                                        <div class="header"> \
                                            <small class="pull-right text-muted"> \
                                                <i class="fa fa-clock-o fa-fw"></i> '+ message.time +'  \
                                            </small>\
                                        </div>\
                                        <p><small><strong class="primary-font">'+username+'</strong>:\
                                            '+ mbody+'\
                                        </small></p>\
                                    </div>\
                                </li>';
	var node = $(htmlnode);
	node.hide();
//	 $('#inbox').val($('#inbox').val()+message.text);
	$("#inbox").prepend(node);
	node.slideDown();
    }
};

function blink(selector){
	$(selector).animate({color: "#EE5F5B"}, 500, function(){
		$(this).animate({ color: "white" }, 500, function(){
			blink(this);
		});
	});
}

