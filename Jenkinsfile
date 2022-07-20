pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
//       booleanParam 'HEADLESS'
//       choice choices: ['chrome', 'edge', 'firefox'], name: 'BROWSER'
//       credentials credentialType: 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl', defaultValue: 'b9ad4ef1-c510-43c3-a659-d5a2718fb10e', name: 'CRQDENTIALS', required: false
//       file '/src/test/resources/regression.xml'
      gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
//       password defaultValue: '', name: 'ADMIN_PASSWORD'
//       run filter: 'SUCCESSFUL', name: 'BASE_URL', projectName: 'SAUCEDEMO_JOB'
//       string name: 'STRING_PARAMETER', trim: true
//       text 'MULTI_LINE_STRING'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/vikalatosh/SauceDemoProject-master.git'

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true -Dbrowser=%BROWSER% -Dheadless=%HEADLESS% clean test"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package" //
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
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