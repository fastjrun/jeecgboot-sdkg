#!/bin/bash

echo "build ..."
if [ "local_jeecgboot_sdkg" = $1 ] ; then
  mvn clean install -pl jeecgboot-sdkg-client,jeecgboot-sdkg-provider,jeecgboot-sdkg-generator -am
elif [ "publish_jeecgboot_sdkg" = $1 ] ; then
  mvn clean deploy -Prelease -pl jeecgboot-sdkg-client,jeecgboot-sdkg-provider,jeecgboot-sdkg-generator -am
elif [ "package_jeecgboot" = $1 ] ; then
  mvn compile -pl jeecgboot-codeg/jeecgboot-api -am -Dapigc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-bundle -am -Dbdgc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-bundle-mock -am -Dbdmgc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-client -am -Dclientgc.skip=false
  mvn package -pl jeecgboot-codeg/jeecgboot-api,jeecgboot-codeg/jeecgboot-bundle,jeecgboot-codeg/jeecgboot-bundle-mock,jeecgboot-codeg/jeecgboot-client -am
elif [ "local_jeecgboot" = $1 ] ; then
  mvn compile -pl jeecgboot-codeg/jeecgboot-api -am -Dapigc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-bundle -am -Dbdgc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-client -am -Dclientgc.skip=false
  mvn install -pl jeecgboot-codeg/jeecgboot-api,jeecgboot-codeg/jeecgboot-bundle,jeecgboot-codeg/jeecgboot-client -am
elif [ "deploy_jeecgboot" = $1 ] ; then
  mvn compile -pl jeecgboot-codeg/jeecgboot-api -am -Dapigc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-bundle -am -Dbdgc.skip=false
  mvn compile -pl jeecgboot-codeg/jeecgboot-client -am -Dclientgc.skip=false
  mvn deploy  -Prelease -pl jeecgboot-codeg/jeecgboot-api,jeecgboot-codeg/jeecgboot-bundle,jeecgboot-codeg/jeecgboot-client -am
elif [ "package_jeecgboot_mock_server" = $1 ] ; then
  mvn package -pl jeecgboot-codeg/jeecgboot-mock-server -am -Dbdmgc.skip=false
elif [ "clean" = $1 ] ; then
  mvn clean
  rm -rf jeecgboot-codeg/jeecgboot-api/src
  rm -rf jeecgboot-codeg/jeecgboot-bundle/src
  rm -rf jeecgboot-codeg/jeecgboot-bundle-mock/src
  rm -rf jeecgboot-codeg/jeecgboot-client/src
elif [ "set_version" = $1 ] ; then
  mvn versions:set -DnewVersion=$2
  cd jeecgboot-codeg
  mvn versions:set -DnewVersion=$2
  cd ..
fi
echo "build done."
