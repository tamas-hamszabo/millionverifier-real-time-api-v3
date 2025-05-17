## Real Time Email Verification on MillionVerifer
Use MillionVerifier's email verification API  to verify email addresses in real time. https://www.millionverifier.com/services/email-verifier-api

You can implement into your application, software or website. Using this API you can prevent invalid and disposable email addresses getting into your subscriber lists.

MillionVerifier offers the fastest real time email verification system on the market at incredibly low prices. 

## PHP, Go, Bash, Python
There are sample codes in this repository for major programming languages.

## Easy to use
There are 3 variables in each API call

[email] - required - the email address you would like to verify

[api] - required - is you unique API key that you can find in your MillionVerifier account https://app.millionverifier.com/api

[timeout] - optional - set after how many seconds should the connection terminate in case the recipient's server is not responding. You can set between 2 and 60 seconds. Default timeout is 20 seconds.

## Test API key
Test API key for developers: "API_KEY_FOR_TEST"

https://api.millionverifier.com/api/v3/?api=API_KEY_FOR_TEST&email=info@email.com

## Response time
MillionVerifier offers the fastest real time API on the market. 
 
## Availability 
24 / 7 - 99.9% uptime

(with 3 backup servers)

## Result Codes - Results
1 - ok

2 - catch_all

3 - unknown

4 - error

5 - disposable

6 - invalid


## Check your credits via API
You can check your credits using https://api.millionverifier.com/api/v3/credits?api=API_KEY
