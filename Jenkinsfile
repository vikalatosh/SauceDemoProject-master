pipeline {
    agent any

    tools {
        maven "M3"
    }

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
                            bat "mvn -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/test/resources/regression.xml test"
                        }
                    }
                }
                stage('Run smoke tests') {
                    steps {
                        script {
                            bat "mvn -Dmaven.test.failure.ignore=true -Dsurefire.suiteXmlFiles=src/test/resources/smoke.xml test"
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