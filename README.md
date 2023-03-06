# snippets

#### Run script from the script location
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

#### Location of the bookmarks in intellij
`~/.config/JetBrains/IntelliJIdea2021.2/workspace`

#### Allow processes to start on ports like 443
`setcap 'cap_net_bind_service=+ep' /usr/bin/node`

#### Markdown to pdf
- `sudo apt-get install pandoc texlive-latex-base texlive-fonts-recommended texlive-extra-utils texlive-latex-extra`
- `[pandoc](https://pandoc.org/) <file name>.md -o <new file name>.pdf`

#### Open stuff on Linux
- `xdg-open <thing>`

#### List all CONFLICTed files in git
- `git diff --name-only --diff-filter=U`

#### Simulate login to bash shell and print everything that happens.
Great for finding where environment variables come from
- PS4='+$BASH_SOURCE> ' BASH_XTRACEFD=7 bash -xl 7>&2

#### Set up AWS CLI (Example)
```
$ aws configure
AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Default region name [None]: us-west-2
Default output format [None]: json
```

#### Packages needed to build Python using pyenv
```
sudo apt-get install make build-essential libssl-dev zlib1g-dev \
libbz2-dev libreadline-dev libsqlite3-dev wget curl llvm \
libncursesw5-dev xz-utils tk-dev libxml2-dev libxmlsec1-dev libffi-dev liblzma-dev
```
#### Command to get the name of a stupid AMI.  I feel like it's hiding in plain sight somewhere on the console.
```
aws ec2 describe-images --region us-east-1 --image-ids ami-1234567890EXAMPLE
```

#### For when you can't change your output device, or rtaher you can change it to anything but sound only comes out of the 
#### headset no matter what in Ubuntu 20.04+
```
rm -r ~/.config/pulse/; sudo shutdown -r now
```


#### Add logging to networking inside AWS Lambda written in Python 
```
import http.client as http_client
import logging

# Debug logging
http_client.HTTPConnection.debuglevel = 1
logging.basicConfig()
logging.getLogger().setLevel(logging.DEBUG)
req_log = logging.getLogger("requests.packages.urllib3")
req_log.setLevel(logging.DEBUG)
req_log.propagate = True
```

#### Sign last commit
`git rebase --exec 'git commit --amend --no-edit -n -S' -i <commit hash>`

#### Keyboard Backlight on the G7 7500 went dark. The value in this file must be 4, not 0:
`cat /sys/devices/platform/dell-laptop/leds/dell\:\:kbd_backlight/max_brightness`

#### List all the conflicts in git
`git diff --name-only --diff-filter=U --relative`


#### A work journal script
```
#!/bin/bash

home=/home/qtpeters
repo=${home}/Repositories/journal
journal=${repo}/aquia-work-journal.md

cd ${repo}
vi ${journal}
git commit -m "Journal Update" ${journal}
git push
cd -
```
