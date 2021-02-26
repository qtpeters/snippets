## Run the following command to verify the client certificate
openssl verify -purpose sslclient -CAfile auth-root.crt testcert.crt

## Run the following command to test the connection with the client:
openssl s_client -servername example.com -connect example.com:443 -key client-cert.key -cert client-cert.crt
