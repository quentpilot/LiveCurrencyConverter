# @Description:         This script would to delete some .class files
# @Author:              Quentin Le Bian <quentpilot>
# @Email:               quentin.lebian@pilotaweb.fr
# @Project:             LiveCurrencyConverter
# @About:               You're welcome to hack and code as your are each of theses sources files <3:p|--<;
# @Filename:            clear.sh
# @Date:                2017-11-04T12:57:26+01:00
# @Last modified by:    quentpilot
# @Last modified time:  2017-11-04T12:57:53+01:00
# @License:             MIT
# @See:                 projects.quentinlebian.fr/LiveCurrencyConverter


#!/bin/bash
exec rm src/Parser/*.class src/Reader/*.class src/Computer/*.class src/Converter/*.class src/Core/CurrencyConverter.class
