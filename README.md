# LiveCurrencyConverter
This project is a simple Java application which would to convert values between different currencies.
This program uses "CurrencyLayer API" (apilayer); keep an eye on them : https://currencylayer.com/, to get online values for a lot of currencies (>160).

## How to test
- Go to LCC project root path. You should to see doc/ resources/ and src/ root directories; also make.sh and clear.sh scripts.
- Execute make.sh from your tty.
- You would to see an instruction message following by an input field to enter a numeric value. This value would to be       converted by a simple arithmetic operation.

## Result
- Different currencies values would to be listed on your terminal.
- By default, I turned off connection to Currencylayer API because we need to sign up from their website. But as you can easily edit code to replace "false" by "true" (line 51 in src/Core/CurrencyConverter.java), you can also create an account on their webapp and enjoy about data we can get from dashboard... more on the wiki, soon...

## Finally
For now, there is no more action possible from user interface, but your free to edit scripts to do what you want. I'm working on, and I would to commit examples soon... I hope :D
