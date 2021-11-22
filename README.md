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
- xdg-open <thing>
