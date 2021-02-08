#!/bin/bash

# This command lists the values of all the rpm variables like $basearch or $arch

# RHEL 6/7
/usr/libexec/platform-python -c 'import dnf, json; db = dnf.dnf.Base(); print(json.dumps(db.conf.substitutions, indent=2))'

# RHEL 8
python -c 'import yum, json; yb = yum.YumBase(); print json.dumps(yb.conf.yumvar, indent=2)'

