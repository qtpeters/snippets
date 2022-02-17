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
