node {
    stage('git chekout') {
        // 镜像仓库至gitee
        git branch: "master", url: 'https://gitee.com/fastjrun/jeecgboot-sdkg.git'
    }
    stage('mvn deploy') {
        sh 'mvn clean deploy -Prelease -pl jeecgboot-sdkg-client,jeecgboot-sdkg-provider,jeecgboot-sdkg-generator -am'
    }
}
