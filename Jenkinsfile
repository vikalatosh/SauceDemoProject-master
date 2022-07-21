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
            parallel {
                stage('Run Products Test') {
                    steps {
                        // Get some code from a GitHub repository
    //                     git branch: "${params.BRANCH}", url: 'https://github.com/vikalatosh/SauceDemoProject-master.git'
                        git 'https://github.com/vikalatosh/SauceDemoProject-master.git'

                        // Run Maven on a Unix agent.
                        // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                        // To run Maven on a Windows agent, use
                        bat "mvn -Dmaven.test.failure.ignore=true -Dtest="ProductsTest" clean test"
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/TEST-*.xml'
                            archiveArtifacts 'target/*.jar'
                        }
                    }
                }
                stage('Run Burger Menu Test') {
                    steps {
                        git 'https://github.com/vikalatosh/SauceDemoProject-master.git'
                        bat "mvn -Dmaven.test.failure.ignore=true -Dtest="BurgerMenuTest" clean test"
                    }
                    post {
                        success {
                            junit '**/target/surefire-reports/TEST-*.xml'
                            archiveArtifacts 'target/*.jar'
                        }
                    }
                }
            }
        }



//             post {
//                 // If Maven was able to run the tests, even if some of the test
//                 // failed, record the test results and archive the jar file.
//                 success {
//                     junit '**/target/surefire-reports/TEST-*.xml'
//                     archiveArtifacts 'target/*.jar'
//                 }
//             }

    }
}