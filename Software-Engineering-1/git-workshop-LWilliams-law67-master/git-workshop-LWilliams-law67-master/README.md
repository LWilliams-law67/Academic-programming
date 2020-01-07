# Git Workshop

After cloning this project by typing `git clone ` followed by the URL you copied from the GitHub assignment link, change into the repository by typing `cd ` followed by the directory you just created via the `clone` command..

Type `ls -a` to see what is in the repo. It should be a bit underwhelming, basically this file, a foo.cpp file and something called `.git/`.
That `.git/` sub-directory is literally the only thing that separates this repo from a _normal_ directory.
It has a bunch of stuff in there that 95% of you will never need to touch.


## Let's add some stuff
Type `touch the sky`.
This is just some Unix magic for creating empty files named _the_ and _sky_.

In between each step below, type `git status` to see what is going on.

1. `git add sky`
1. `git add .`
1. `git reset`
1. `git add .`
1. `vi sky`
	1. Type some random stuff into the file.
	1. `git status` - sky is shown twice??
1. `git diff`  - show diff between pwd and staging area


## See how a small change can set you back
1. First commit what you've got by adding all files to the staging area and committing those changes.
1. Compile foo, by typing `g++ foo.cpp`.
1. Now run the executable `./a.out`.
	1. Check out the output.
1. Now, type `sed -i '' -e '/\wd/' foo.cpp` if on a Mac, or `sed -i '/\wd/' foo.cpp` on Linux.
1. Compile foo.cpp again and run it again.
	1. Review the output. It should look the same. **It's not the same program**.
	1. The first version is _arguably_ just fine, but the second has a major flaw. What changed? How do we fix it?

If you have figured it out the easy way, good for you; you are getting the hang of Git.
If you had to run both executables through `valgrind` to notice that one of them is a disaster, good on you too, but the Git way is **much** simpler.

## Resolving the error
1. There are tons of file diff tools like kompare, meld, tkdiff, et al.
If you've never used any, for this short exercise, you can use mine (yay more Vim) :)
1. First set your difftool, by running `git config diff.tool vimdiff`.
1. Now compare away by running: `git difftool`.
	1. To move your cursor to the next change in the file, type `]c`.
	1. If you want back the old change, you can type `do` (stands for **d**iff **o**btain from other window).
1. The file is in a read-only state, so to write you'll have to type `:w!`.
Normally you only need `:w` to write to disk in Vim, but read-only files require some extra assurance.
1. After writing, you can close all windows by typing `:qa` to quit all.
	1. You can now get the git status and you should see
	>nothing to commit, working tree clean


----

## Resolving conflicts
When you are working alone, on a single computer the likelihood of encountering a merge conflict is rather slim.
However, when you graduate (or sooner), you'll be working on group projects, which _should_ mean that you are working in branches on your individual tasks.
It's a race to see who commits their code first and the loser often has to deal with conflicts.

1. Create a new branch by running `git checkout -b ` followed by the name for your new branch.
To create a branch named Foo, run `git checkout -b Foo`.
1. Make a change to the foo.cpp file by deleting the conditional block that says "WHOA" in the body.
1. Commit that change.
1. Switch back to master `git checkout master`.
1. Open foo.cpp and change the word "WHOA" to "WOW".
1. Commit that change.
1. Now try to merge in the other branch by typing `git merge Foo`, or simply `git merge -`.

```
Auto-merging foo.cpp
CONFLICT (content): Merge conflict in foo.cpp
Automatic merge failed; fix conflicts and then commit the result.
```
You'll see that you now have conflicts. You are trying to merge in a change that occupies the same space as another change and Git doesn't know what you want it to do.
Open the foo.cpp file and search for `<<<<`, since this is a short file you'll see it right away.
The code on the lines between <<<<< and ==== is what is in the HEAD, which is the last commit in the current branch.
The code between the =====  and >>>>> lines is what you were trying to merge in.
In this simple example, there is nothing because we _deleted_ those lines of code.
Merge conflicts are a manual process that require a developer to look at the two sets of changes and figure out which combination of those changes is "correct".

1. Once you decide what you want to do, do it then run `git add foo.cpp` to stage those changes.
1. After staging, you wannt to complete the merge by typing `git merge --continue`.

Conflict resolved.


----

## SSH
If you use GitHub a lot, you're probably tired of typing your username/password every time you try to pull and push.
If you are on a trusted computer, you can install an SSH key that will bypass that.
Go to https://help.github.com/en/enterprise/2.15/user/articles/adding-a-new-ssh-key-to-your-github-account to see the steps, since anything I put here is likely to be superceded.

The basic breakdown of the process is:
1. Create an SSH key on your local machine using a tool such as `ssh-keygen`.
1. Copy the contents of the _.pub_ file, by default, it is ~/.ssh/id_rsa.pub on a \*nix style system like Ubuntu, or a Mac.
	1. Personally I set my key name to _github_ to avoid potentially being overwritten and to make it clear what the token is for.
1. Go to GitHub and paste the key into your profile settings under "SSH keys".
1. Add the line below to your login script (~/.profile or ~/.bash_rc) to load the ssh key when you login and you're all set.
	1. Note that this assumes you've named your key set _github_, and not the default id_rsa.
```bash
ssh-add ~/.ssh/github >/dev/null 2>&1
```