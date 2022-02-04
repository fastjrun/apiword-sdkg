node {
    stage('git chekout') {
        // 镜像仓库至gitee
        git branch: "master", url: 'https://gitee.com/fastjrun/apiworld-sdkg.git'
    }
    stage('mvn deploy') {
        sh 'mvn clean deploy -Prelease -pl apiworld-sdkg-client,apiworld-sdkg-provider,apiworld-sdkg-generator -am'
    }
}
