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
    for filename in ./*.java; do
        filename=$(echo "$filename" | cut -c 3- | cut -f 1 -d '.')
        testClass "$filename"
    done
}

function testClass()
{
    filename="$1"
    echo "  Testing "$filename" Class..."
    javac "$filename".java
    java "$filename" -test
    rm "$filename".class
}

#----------------------------------------------------------------------------------------------------------------------
# SCRIPT
#----------------------------------------------------------------------------------------------------------------------
    main
