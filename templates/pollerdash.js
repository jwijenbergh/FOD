
var xhrlp = '';
$(document).ready(function() {
    if (!window.console) window.console = {};
    if (!window.console.log) window.console.log = function() {};

    $("#message").select();
    {% if user.is_authenticated %}
    updater.start();
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

var updater = {
    started: false,
    last_ids: new Object(),
    start: function() {
	    //console.log("Initial fetching of all notifications.");
	    {% for peer in user.userprofile.peers.all %}
	    updater.last_ids["{{ peer.pk }}"] = null;
        try {
	    $.ajax({url: "{% url 'fetch-existing'  peer.pk %}", type: "POST", dataType: "json", cache:false,
			    success: updater.onFetchExisting,
			    error: updater.onError});
        } catch (e) {
            console.log("Error: " + e);
        }
	    {% endfor %}
    },
    poll: function() {
    	{% if user.is_authenticated %}
    	timeout = {{timeout}};
        {% for peer in user.userprofile.peers.all %}
        //console.log("Polling new notifications from", updater.last_ids["{{ peer.pk }}"], "peerid {{ peer.pk }}");
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
            var errdialog = $('#ajaxerror')
            if (errdialog[0]) {
                errdialog[0].remove();
            }
            if (oTable) {
                try {
                    oTable.fnReloadAjax(refreshUrl);
                } catch (e) {
                    console.log("DataTable reload failed.");
                }
            }
        } catch (e) {
            console.log(e);
            return;
        }
    },

    onFetchExisting: function(response) {
    	try {
    	    updater.existingMessages(response);
    	    if (updater.started == false) {
                updater.started = true;
                setInterval(updater.poll, 3000);
            }
    	} catch (e) {
            console.log(e);
    	    updater.onError();
    	    return;
    	}
    },

    onError: function(response, text) {
        var errdialog = $('#ajaxerror');
        if (!errdialog[0]) {
           $('#page-wrapper').after("<div id='ajaxerror'>Loading...</div>");
        }
        $('#ajaxerror').css({"position": "fixed", "right": "100px", "bottom": "10px", "padding": "5px", "font-weight": "bold", "color": "#fff", "background-color": "#f00", "z-index": "10"});
    },

    newMessages: function(response) {
        if (!response || !response.messages) return;
        if (response.messages.length == 0){
            return true;
        }
        var messages = response.messages;
        var peerid = messages[messages.length - 1]["peerid"];
        var msgid = messages[messages.length - 1]["id"];
        updater.last_ids[peerid] = msgid;
        //console.log(messages.length, "new messages, last_id:", msgid, "peerid", peerid);

        var reloadContent = false;
        for (var i = 0; i < messages.length; i++) {
            updater.showMessage(messages[i]);
            if (messages[i].body.match(/Successfully committed$/)) {
                reloadContent = true;
            }
        }
        $("#hid_mid").val('UPDATED');
        if (reloadContent) {
            if (oTable) {
                try {
                    oTable.fnReloadAjax(refreshUrl);
                } catch (e) {
                    console.log("DataTable reload failed.");
                }
            } else {
                location.reload();
            }
        }
    },

    existingMessages: function(response) {
    	if (!response || !response.messages) return;
    	if (response.messages.length == 0){
            return true;
    	}
        $("#inbox").empty();
    	var messages = response.messages;
        var peerid = messages[messages.length - 1]["peerid"];
        var msgid = messages[messages.length - 1]["id"];
        updater.last_ids[peerid] = msgid;
        //console.log("got", messages.length, "messages with last_id", msgid);
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

