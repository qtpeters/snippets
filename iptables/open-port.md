
## Open port 5901 for vncviewer
iptables -I INPUT 1 -p tcp --dport 5901 -j ACCEPT
