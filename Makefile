
help:
	@grep -E "^[^ ]+:" Makefile | grep -v ^help

docu-html:
	mkdocs build	

