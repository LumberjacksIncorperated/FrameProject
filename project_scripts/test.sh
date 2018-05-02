#!/bin/sh

#----------------------------------------------------------------------------------------------------------------------
#
# PROJECT
# -------
# Frame Project
#
# AUTHOR
# ------
# Lumberjacks Incorperated (2018)
#
#----------------------------------------------------------------------------------------------------------------------

#----------------------------------------------------------------------------------------------------------------------
# MAIN
#----------------------------------------------------------------------------------------------------------------------
main()
{
    echo "<START>"
    
    echo "Testing All Classes"
    testAllClasses
    
    echo "<DONE>"
}

#----------------------------------------------------------------------------------------------------------------------
# INTERNAL FUNCTIONS
#----------------------------------------------------------------------------------------------------------------------
function testAllClasses()
{
    cd ../java_files/
    testWindowClass
    testDisplayInformationDatabaseClass
    testLiveInformationDisplayClass
    testLiveInformationDisplayApplicationClass
}

function testWindowClass()
{
    echo "  Testing Window Class..."
    javac Window.java
    java Window
    rm *.class
}

function testDisplayInformationDatabaseClass()
{
    echo "  Testing DisplayInformationDatabase Class..."
    javac DisplayInformationDatabase.java
    java DisplayInformationDatabase
    rm *.class
}

function testLiveInformationDisplayClass()
{
    echo "  Testing LiveInformationDisplay Class..."
    javac LiveInformationDisplay.java
    java LiveInformationDisplay
    rm *.class
}

function testLiveInformationDisplayApplicationClass()
{
    echo "  Testing LiveInformationDisplayApplication Class..."
    javac LiveInformationDisplayApplication.java
    java LiveInformationDisplayApplication -test
    rm *.class
}

#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main
