>1. **git init** :瞬间Git就把仓库建好了，而且告诉你是一个空的仓库（empty Git repository），细心的读者可以发现当前目录下多了一个.git的目录，这个目录是Git来跟踪管理版本库的，没事千万不要手动修改这个目录里面的文件，不然改乱了，就把Git仓库给破坏了.  
>2. 把文件添加到版本库：`git add readme.txt`(readme.txt该文件)/`git add .`(当前目录)  
>3. 把文件提交到仓库：git commit -m "提交信息"
--------------------------------------------------
二：从远程库中克隆项目:
	git.exe clone --progress -v "http://gitzx.itbo.cc:33516/zxlab/admin.git" "C:\programmer\git\repository\admin"
	git clone git@github.com:michaelliao/gitskills.git
克隆远程项目的特定分支：
	git.exe clone --progress -v "http://gitzx.itbo.cc:33516/zxlab/admin.git" -b <分支名称>
	使用ssh链接无法访问，不知道什么原因，之后在做深入研究
-------------------------------------------------
三：分支问题
	1.创建dev分支，然后切换到dev分支：
		git checkout -b dev
	2.git checkout命令加上-b参数表示创建并切换，相当于以下两条命令：
		git branch dev ----创建新分支dev
		git checkout dev ----切换到分支dev
	3.用git branch命令查看当前分支
		git branch


	4.合并分支，对于提交到远程服务器的master上很有作用(建议都在dev分支上工作，然后合并到master分支上)
		---dev分支和master分支，想把dev分支合并到master分支上
		1.切换到mater分支
		2.git merge dev(使用的是fast-forward方式，类似于指针移动的方式，速度很快)
		3.合并完成后，就可以删除分支了，使用 git branch -d dev方式
	5.分支管理策略（不使用fast-forward模式）
		合并分支：git merge --no-ff -m "merge with no-ff" dev

	6.修复bug时，我们会通过创建新的bug分支进行修复，然后合并，最后删除；
       当手头工作没有完成时，先把工作现场git stash一下，然后去修复bug，修复后，再git stash pop，回到工作现场。

------------------------------------------------
四：
	1.推送到远程服务器
		git push origin master：origin本地仓库的分支，master远程仓库的分支名
	2.从服务器取回更新
		git pull origin master:解释同上
	注:
	1.origin 是默认的远程版本库名称
	2.你可以在 .git/config 之中进行修改
	3.事实上 git push origin master 的意思是 git push origin master:master （将本地的master(冒号前的那个master) 分支推送至远端的 master(冒号后的master) 分支，如果没有就新建一个）

	注：如果本地仓库直接删除了文件，而服务器和本地仓库之前是同步的，需要用“恢复版本”找回之前的文件
五：恢复版本
	git reset --hard HEAD               恢复到最近提交的版本
	git reset --hard HEAD^				 恢复到最近提交的上一个
	git reset --hard HEAD^^				 恢复到最近提交的上上一个
	git reset –hard aabbc               恢复到指定版本(上述git lg 列出的版本)
六:恢复工作区/工作区文件(git checkout),和更换分支是一个命令
	其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”
	恢复所有：git checkout *
	恢复指定文件：git checkout README.txt


.gitingnore文件 ：
	.gitignore有两种文件过滤模式，开放模式和保守模式
	1.开放模式是设置哪些文件和文件夹要被过滤，例如：
		target/ 表示过滤这个文件夹
	2.保守模式设置哪些文件不被过滤
		!/src/com
	3.这是他人过滤的文件标准
  ```java
		# maven ignore
		target/

		# eclipse ignore
		.settings/
		.project
		.classpath

		# idea ignore
		.idea/
		*.ipr
		*.iml
		*.iws

		# temp ignore
		*.log
		*.cache
		*.diff
		*.patch
		*.tmp

  	# system ignore
  	.DS_Store
  	Thumbs.db

  	# package ignore (optional)
  	# *.jar
  	# *.war
  	# *.zip
  	# *.tar
  	# *.tar.gz
