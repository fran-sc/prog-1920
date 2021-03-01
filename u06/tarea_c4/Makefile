# java Makefile

PROJ_NAME = $(shell basename $(CURDIR))

#---------------------------------------------------------------------------------------------------------
# Main App
MAIN = c4.ConsoleApp

# Packages 
PACKAGES = c4 c4.tree

# Libraries
LIB_CP = 

# Source path
SPATH = src/main/java/
SRCS = $(foreach PKG, $(PACKAGES), $(wildcard $(SPATH)$(subst .,/,$(PKG)))/*.java)

# Destiny path
DPATH = target/classes/

# Classpath
CP = .:$(DPATH):$(LIB_CP)

#---------------------------------------------------------------------------------------------------------
# Distribution
JAR_PATH = target/dist/

#---------------------------------------------------------------------------------------------------------
# Documentation
DOC_PATH = docs/

#---------------------------------------------------------------------------------------------------------
# Tests
TEST_CLASS =  
TEST_RUNNER = org.junit.runner.JUnitCore

# Packages 
TEST_PACKAGES = c4 c4.tree

# Libraries
JUNIT4_CP = /home/zeroth/work/lib/java/junit-4.13.1.jar:/home/zeroth/work/lib/java/hamcrest-core-1.3.jar
TEST_LIB_CP = $(JUNIT4_CP)

# Source path
TEST_SPATH = src/test/java/
TEST_SRCS = $(foreach PKG, $(TEST_PACKAGES), $(wildcard $(TEST_SPATH)$(subst .,/,$(PKG)))/*.java)

# Destiny path
TEST_DPATH = target/test-classes/

# Test classpath
TEST_CP = .:$(DPATH):$(TEST_DPATH):$(TEST_LIB_CP)

#---------------------------------------------------------------------------------------------------------
# Targets

JVM = java
JFLAGS = -g
JC = javac
JAR = jar
JDOC = javadoc
MDIR = mkdir -p

classes: 
	$(JC) -d $(DPATH) $(SRCS)

classes-debug: 
	$(JC) $(JFLAGS) -d $(DPATH) $(SRCS)

run: classes
	$(JVM) -cp $(CP) $(MAIN)

debug: classes-debug
	$(JVM) -cp $(CP) -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n $(MAIN)

jar: classes
	jar cvfe $(JAR_PATH)$(PROJ_NAME).jar $(MAIN) -C $(DPATH) .

test-classes: 
	$(JC) -cp $(TEST_CP) -d $(TEST_DPATH) $(TEST_SRCS)

test: test-classes
	$(JVM) -cp $(TEST_CP) $(TEST_RUNNER) $(TEST_CLASS)

jdocs:
	$(JDOC) --frames -d $(DOC_PATH) -sourcepath $(SPATH) $(PACKAGES)

clean: 
	$(RM) -r $(DPATH)*
	$(RM) -r $(TEST_DPATH)*
	$(RM) -r $(JAR_PATH)*
	$(RM) -r $(DOC_PATH)*

init:
	#$(RM) -r *  # Dangerous!!!
	$(MDIR) -p $(foreach PKG_DIR, $(PACKAGES), $(SPATH)$(subst .,/,$(PKG_DIR)))
	$(MDIR) -p $(foreach PKG_DIR, $(TEST_PACKAGES), $(TEST_SPATH)$(subst .,/,$(PKG_DIR)))

