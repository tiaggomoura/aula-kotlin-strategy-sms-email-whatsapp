# aula-kotlin-strategy-sms-email-whatsapp

This project was to illustrate an api for sending confirmation codes (2FA) in a simplified way through integrations with external APIs such as Telesign, GtiSms and Google Mail, using the Strategy design pattern.

## Running the Application

1. Install JDK-11

2. Install Docker and execute the command:

	 docker run --name postgresql --env=POSTGRESQL_DATABASE=postgres --env=POSTGRES_USERNAME=postgres --env=POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres

3. Create an account and get your API key at https://www.telesign.com for SMS sending. Also create an account at https://www.gtisms.com/ and get your API key for sending Whatsapp (Need to buy credits).

4. Create a GMAIL account and set up 2FA and a key for your app so you can send emails through it.

5. Run the app and enjoy!


