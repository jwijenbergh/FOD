
# wrapper for maven and running of compiled Tests assuming debian buster 
#

help:
	@grep -E "^[a-zA_Z_][^ :]+:" Makefile

##

ensuremaven:
	which mvn | grep -q . || apt-get install -qyy maven

##

ensurevnc0running00:
	which Xvnc | grep -q . || apt-get install -qyy tightvncserver 
	which xterm | grep -q . || apt-get install -qyy xterm
	which xdpyinfo | grep -q . || apt-get install -qyy x11-utils

ensurevnc0running01:
	DISPLAY=:0 xdpyinfo >/dev/null && echo "xserver already ok" || make startvnc0

ensurevnc0running0: ensurevnc0running00 ensurevnc0running01

ensurevnc0running: ensuretestuser1
	make ensurevnc0running00
	which sudo | grep -q . || apt-get install -qyy sudo
	sudo -u test1 make ensurevnc0running01

##

ensuretestuser1:
	id test1 || useradd -m -s /bin/bash test1

startvnc0:
	Xvnc -geometry 1900x1024 -depth 24 :0 & 
	sleep 1
	DISPLAY=:0 xdpyinfo >/dev/null && echo "xserver/vnc ok"
	DISPLAY=:0 xterm &

##

ensurechromedriver:
	test -x /usr/local/bin/chromedriver || make installchromedriver

installchromedriver:
	apt-get install -qqy chromium #firefox-esr 
	apt-get install -qyy curl unzip openjdk-11-jre-headless xvfb libxi6 libgconf-2-4 gnupg2
	curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
	echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
	apt-get -y update
	apt-get -y install google-chrome-stable

	# TODO: find an suitable version:
	#RUN wget -N https://chromedriver.storage.googleapis.com/$(google-chrome --version | grep -Eo "[0-9\.]+")/chromedriver_linux64.zip -P /root/
	wget -N https://chromedriver.storage.googleapis.com/89.0.4389.23/chromedriver_linux64.zip -P /root
	unzip /root/chromedriver_linux64.zip -d /root
	mv -f /root/chromedriver /usr/local/bin/chromedriver
	chown root:root /usr/local/bin/chromedriver
	#chmod 0755 /usr/local/bin/chromedriver

##

clean: ensuremaven
	mvn clean

package1: ensuremaven
	#mvn clean compile package assembly:single
	mvn compile package assembly:single

CLASS1:=Login

chg_src_login_url1:
	echo "$(LOGIN_URL1)" > "src/Tests/$(CLASS1).url.$$"
	if ! diff "src/Tests/$(CLASS1).url.$$" "src/Tests/$(CLASS1).url"; then \
	  mv -f "src/Tests/$(CLASS1).url.$$" "src/Tests/$(CLASS1).url"; \
	  sed -i  -r 's/^(\s*String url =).*/\1 "$(LOGIN_URL1)\/altlogin";/' src/Tests/$(CLASS1).java; \
	fi
	echo "$(LOGIN_USER1)" > "src/Tests/$(CLASS1).pwd.$$"
	if ! diff "src/Tests/$(CLASS1).user.$$" "src/Tests/$(CLASS1).user"; then \
	  mv -f "src/Tests/$(CLASS1).user.$$" "src/Tests/$(CLASS1).user"; \
	  sed -i  -r 's/"id_username".*sendKeys.*$$/"id_username"\)\).sendKeys\("'"$(LOGIN_USER1)"'"\)\;/' src/Tests/$(CLASS1).java; \
	fi
	echo "$(LOGIN_PWD1)" > "src/Tests/$(CLASS1).pwd.$$"
	if ! diff "src/Tests/$(CLASS1).pwd.$$" "src/Tests/$(CLASS1).pwd"; then \
	  mv -f "src/Tests/$(CLASS1).pwd.$$" "src/Tests/$(CLASS1).pwd"; \
	  sed -i  -r 's/"id_password".*sendKeys.*$$/"id_password"\)\).sendKeys\("'"$(LOGIN_PWD1)"'"\)\;/' src/Tests/$(CLASS1).java; \
	fi
	make ./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar

java_file_list=$(wildcard src/Tests/*.java)
url_file_list=$(wildcard src/Tests/*.url)

#./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar: src/Tests/Login.url $(url_file_list) $(java_file_list)
./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar: $(java_file_list)
	make package1

run1: ensurechromedriver
	#sed -i  -r 's/^(\s*String url =).*/\1 "http:\/\/172.17.0.2:8000\/altlogin";/' src/Tests/Login.java
	#make package1
	make chg_src_login_url1 LOGIN_URL1='http:\/\/172.17.0.2:8000' LOGIN_USER1='admin2' LOGIN_PWD1='adminpwd1' CLASS1="$(CLASS1)"
	make ./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar
	ln -sf /usr/local/bin/chromedriver .\\driver\\chromedriver.exe
	echo "X server (e.g. vnc) should be running on :0 and be accessible for test 1 user" 1>&2
	#xdpyinfo
	make ensurevnc0running
	#DISPLAY=:0 java -cp ./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar Tests.Login
	#sudo -u test1 env DISPLAY=:0 java -cp ./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar Tests.Login
	sudo -u test1 env DISPLAY=:0 java -cp ./target/fodselenium-0.0.1-SNAPSHOT-jar-with-dependencies.jar "Tests.$(CLASS1)"

full1: clean package1 run1
	@true

