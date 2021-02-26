### Verify the client certificate
openssl verify -purpose sslclient -CAfile auth-root.crt testcert.crt

### Test the connection with the client
openssl s_client -servername example.com -connect example.com:443 -key client-cert.key -cert client-cert.crt

### Test cert chain
openssl verify -verbose -CAfile RootCert.pem Intermediate.pem
openssl verify -verbose -CAfile CertChain.pem UserCert.pem
