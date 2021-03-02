### Verify the client certificate
openssl verify -purpose sslclient -CAfile auth-root.crt testcert.crt

### Test the connection with the client
openssl s_client -servername example.com -connect example.com:443 -key client-cert.key -cert client-cert.crt

### Test cert chain
openssl verify -verbose -CAfile RootCert.pem Intermediate.pem
openssl verify -verbose -CAfile CertChain.pem UserCert.pem

### Test match private key
#### For your SSL certificate:
openssl x509 –noout –modulus –in <file>.crt | openssl md5

#### For your RSA private key: 
openssl rsa –noout –modulus –in <file>.key | openssl md5

#### For your CSR: 
openssl req -noout -modulus -in <file>.csr | openssl md5
