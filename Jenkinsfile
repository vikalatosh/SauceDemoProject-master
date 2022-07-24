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
                stage ('Run regression tests') {
                    steps {
                        script {
                            bat "mvn -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/test/resources/regression.xml clean test"
                        }
                    }
                }
                stage('Run smoke tests') {
                    steps {
                        script {
                            bat "mvn -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/test/resources/smoke.xml clean test"
                        }
                    }
                }
            }
        }
        stage('Reporting') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}