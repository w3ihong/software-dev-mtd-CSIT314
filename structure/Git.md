Git, collaboration, version, and source code control tool simple usage:

1. Clone a project into local machine:
```shell
git clone "<source-code-url>"
```
2. Add changes into Git staging:
- Add all files
```shell
git add .
```
- Add certain file
```shell
git add <filename>
```

3. Commit code
- first option
```shell
git commit -m "purpose of this commit"
```
- second option
```shell
git commit -a -m "message here"
```
4. Push
```shell
git push
```

5. Pull the latest changes into the local code
```shell
git pull
```

Others:
Checkout new branch
```shell
git checkout -b <branch-name>
```
Switch branch
```shell
git checkout main
git checkout dev
...
```
View existing branches
```shell
git branch
```