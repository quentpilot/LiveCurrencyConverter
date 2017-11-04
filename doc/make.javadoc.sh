# @Description:         This script would to create a javadoc of src/ repository
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             LiveCurrencyConverter
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            make.sh
# @Date:                2017-11-04T15:01:45+01:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-11-04T16:23:17+01:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/LiveCurrencyConverter


# get current path
pwd=$(pwd)

# clear resources/javadoc repository
rm -r $pwd/javadoc/*

# create needed doc/javadoc repositories
mkdir $pwd/javadoc/src/
mkdir $pwd/javadoc/www/
mkdir $pwd/javadoc/tar/

# import new java sources
cp -r $pwd/../src/* $pwd/javadoc/src

# execute javadoc program
javadoc -d $pwd/javadoc/www/ -cp '.:../resources/lib/gson-2.8.0.jar:../resources/lib/json-20140107.jar:../resources/lib/httpcore-4.4.7.jar:../resources/lib/httpclient-4.5.3.jar:../resources/lib/commons-logging-1.2.jar'  $pwd/javadoc/src/*/**.java

# create .tar file containing new javadoc files to export it easily
tar -cf ../resources/javadoc/LCC.javadoc.tar javadoc/www/*
cp $pwd/../resources/javadoc/* $pwd/javadoc/tar/
rm -r javadoc/src
