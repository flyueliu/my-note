#!/usr/bin/env python3
import os
import pexpect

print(os.curdir)
child = pexpect.spawn("/cygdrive/d/'Program Files'/Git/cmd/git pull test master")
fout = open('mylog.txt', 'wb')
child.logfile = fout
res = child.expect(['root', '@', 'password:', pexpect.EOF])
print(res)
child.sendline("root")
child.expect("$")
print(child.after)
print(child.before)
