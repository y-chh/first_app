## How to use CLI to create a git repo?
echo "# first_app" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:y-chh/first_app.git
git push -u origin main