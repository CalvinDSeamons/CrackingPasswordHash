## Computer Security MD5 Encryption Cracker. 

The title is slightly misleading. This program does not actually crack the encryption but still lets us break into the 
password hash, in a sense. We use a large dictionary list of stolen and common passwords and encrypt them into MD5. We then 
compare the hashes and if we get a match we know what the encrypted password is. So in essence this is a combination of brute-
force and relying on people to choose poor passwords. This dictionary list consists of roughly 1.5Billion passwords so Github 
wont let me upload it :( 

Link to password list: https://crackstation.net/crackstation-wordlist-password-cracking-dictionary.htm

If you ever find yourself with a large list of MD5 hashed passwords. You will most likely be able to crack it. 
