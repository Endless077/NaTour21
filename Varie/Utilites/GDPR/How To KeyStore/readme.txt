Generazione di un hash della firma per lo sviluppo.
Questo valore cambierà per ogni ambiente di sviluppo.

Windows:
keytool -exportcert -alias androiddebugkey -keystore %HOMEPATH%\.android\debug.keystore | openssl sha1 -binary | openssl base64

---

Generazione di un hash della firma per la produzione.

keytool -exportcert -alias SIGNATURE_ALIAS -keystore PATH_TO_KEYSTORE | openssl sha1 -binary | openssl base64	

------------------------------------------------------------------------------------------------------------

How To Create a KeyStore:

~\Utilites\Keystore\keystore.jks

Password: KeyStore21

Alias: NaTour21

Validity: 25 years

Certificate:

- First and Last Name: -
- Organizational Unit: NaTour21
- Organization: Università degli Studi di Napoli - Federico II
- City or Locality: Naples
- State or Province: Italy
- Country Code (XX): -

*il simbolo "-" indica che il campo è lasciato vuoto.

------------------------------------------------------------------------------------------------------------
