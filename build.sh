#!/bin/bash

echo "build ..."
if [ "local_apiworld_sdkg" = $1 ] ; then
  mvn clean install -pl apiworld-sdkg-client,apiworld-sdkg-provider,apiworld-sdkg-generator -am
elif [ "publish_apiworld_sdkg" = $1 ] ; then
  mvn clean deploy -Prelease -pl apiworld-sdkg-client,apiworld-sdkg-provider,apiworld-sdkg-generator -am
elif [ "package_apiworld" = $1 ] ; then
  mvn compile -pl apiworld-codeg/apiworld-api -am -Dapigc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-bundle -am -Dbdgc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-bundle-mock -am -Dbdmgc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-client -am -Dclientgc.skip=false
  mvn package -pl apiworld-codeg/apiworld-api,apiworld-codeg/apiworld-bundle,apiworld-codeg/apiworld-bundle-mock,apiworld-codeg/apiworld-client -am
elif [ "local_apiworld" = $1 ] ; then
  mvn compile -pl apiworld-codeg/apiworld-api -am -Dapigc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-bundle -am -Dbdgc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-client -am -Dclientgc.skip=false
  mvn install -pl apiworld-codeg/apiworld-api,apiworld-codeg/apiworld-bundle,apiworld-codeg/apiworld-client -am
elif [ "deploy_apiworld" = $1 ] ; then
  mvn compile -pl apiworld-codeg/apiworld-api -am -Dapigc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-bundle -am -Dbdgc.skip=false
  mvn compile -pl apiworld-codeg/apiworld-client -am -Dclientgc.skip=false
  mvn deploy  -Prelease -pl apiworld-codeg/apiworld-api,apiworld-codeg/apiworld-bundle,apiworld-codeg/apiworld-client -am
elif [ "package_apiworld_mock_server" = $1 ] ; then
  mvn package -pl apiworld-codeg/apiworld-mock-server -am -Dbdmgc.skip=false
elif [ "clean" = $1 ] ; then
  mvn clean
  rm -rf apiworld-codeg/apiworld-api/src
  rm -rf apiworld-codeg/apiworld-bundle/src
  rm -rf apiworld-codeg/apiworld-bundle-mock/src
  rm -rf apiworld-codeg/apiworld-client/src
fi
echo "build done."
