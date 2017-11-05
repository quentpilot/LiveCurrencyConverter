# @Description:         This script would to build & run java sources
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             LiveCurrencyConverter
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            make.sh
# @Date:                2017-11-04T12:12:02+01:00
# @Last modified by:    quentin
# @Last modified time:  2017-11-05T03:36:54+01:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/LiveCurrencyConverter


#!/bin/bash
javac -cp '.:resources/lib/gson-2.8.0.jar:resources/lib/json-20140107.jar:resources/lib/httpcore-4.4.7.jar:resources/lib/httpclient-4.5.3.jar:resources/lib/commons-logging-1.2.jar' src/Parser/*.java src/Reader/*.java src/Computer/*.java src/Converter/*.java src/Settings/*/**.java src/Core/*.java
java -cp '.:resources/lib/gson-2.8.0.jar:resources/lib/json-20140107.jar:resources/lib/httpcore-4.4.7.jar:resources/lib/httpclient-4.5.3.jar:resources/lib/commons-logging-1.2.jar' src.Core.CurrencyConverter
