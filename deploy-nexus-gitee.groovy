node {
    stage('git chekout') {
        git branch: "master", url: 'https://gitee.com/fastjrun/apiworld-sdkg.git'
    }
    stage('mvn deploy') {
        sh 'sh build.sh publish_apiworld_sdkg'
    }
}
