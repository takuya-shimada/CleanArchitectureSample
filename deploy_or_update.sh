#!/bin/bash

# Determining whether the upload target
if [ `git log -n 1 --oneline | grep "Merge pull request" -c` -eq 0 ]; then
./gradlew :app:uploadDeployGateDebug
exit 0
fi

# ここからバージョンの書き換え処理開始
file=app/build.gradle
branch=`git log -n1 --oneline --decorate=short | grep -o -e "origin\/[a-z/_.0-9]\+" | sed -e "s/^origin\///g"`

## ブランチをチェックアウト
git checkout ${branch}
git branch

## バージョンを取得
version_major=`cat ${file} | grep -o "versionMajor = \(.*\)" | sed -e "s/^versionMajor = //g"`
version_minor=`cat ${file} | grep -o "versionMinor = \(.*\)" | sed -e "s/^versionMinor = //g"`
version_patch=`cat ${file} | grep -o "versionPatch = \(.*\)" | sed -e "s/^versionPatch = //g"`
version_build=`cat ${file} | grep -o "versionBuild = \(.*\)" | sed -e "s/^versionBuild = //g"`
version_build=$(( ++version_build ))

## version_buildを置換
LANG=C
NOLOCALE=1
find -maxdepth 1 -name "${file}" | xargs sed -i "s/versionBuild = \(.*\)/versionBuild = $version_build/"

## コミット
repository=tyfrontier/CleanArchitectureSample

git config --global user.email "shimada@1923.co.jp"
git config --global user.name "Takuya Shimada"
git add ${file}
git commit -m "[deploy] r${version_build} v${version_major}.${version_minor}.${version_patch}"
git push -f git@github.com:${repository} ${branch}
