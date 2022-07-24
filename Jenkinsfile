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
        stage ('Checkout') {
            steps {
                git 'https://github.com/vikalatosh/SauceDemoProject-master.git'
            }
        }
        stage ('Run in parallel') {
            parallel {
                stage ('Run Products Test') {
                    steps {
                        script {
                            bat "mvn -Dmaven.test.failure.ignore=true -Dtest='Thread1' -DfailIfNoTests=false clean test"
                        }
                    }
//                     post {
//                         success {
//                             junit '**/target/surefire-reports/TEST-*.xml'
//                             archiveArtifacts 'target/*.jar'
//                         }
//                     }
                }
                stage('Run Burger Menu Test') {
                    steps {
                        script {
                            bat "mvn -Dmaven.test.failure.ignore=true -Dtest='Thread2' -DfailIfNoTests=false clean test"
                        }
                    }
//                     post {
//                         success {
//                             junit '**/target/surefire-reports/TEST-*.xml'
//                             archiveArtifacts 'target/*.jar'
//                         }
//                     }
                }
            }
        }
    }
}