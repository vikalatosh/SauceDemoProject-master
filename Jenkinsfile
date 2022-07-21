pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

//     parameters {
//       gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
//     }

    stages {
        stage ('Run in parallel') {
            parallel (
                'Run Products Test': {
                    steps {
                        script {
                             git 'https://github.com/vikalatosh/SauceDemoProject-master.git'
                             bat "mvn -Dmaven.test.failure.ignore=true -Dtest="ProductsTest" clean test"
                        }
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/TEST-*.xml'
                            archiveArtifacts 'target/*.jar'
                        }
                    }
                },
                'Run Burger Menu Test': {
                    steps {
                        script {
                            git 'https://github.com/vikalatosh/SauceDemoProject-master.git'
                            bat "mvn -Dmaven.test.failure.ignore=true -Dtest="BurgerMenuTest" clean test"
                        }
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/TEST-*.xml'
                            archiveArtifacts 'target/*.jar'
                        }
                    }
                }
            )
        }
    }
}