
help:
	@grep -E "^[^ ]+:" Makefile | grep -v ^help

docu-html:
	which mkdocs 2>/dev/null >/dev/null || apt-get install mkdocs
	mkdocs build	

