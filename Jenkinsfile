pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
      booleanParam 'HEADLESS'
      choice choices: ['Chrome', 'Edge', 'Firefox'], name: 'BROWSER'
      gitParameter branch: '', branchFilter: '.*', defaultValue: 'master', name: 'BRANCH', quickFilterEnabled: false, selectedValue: 'NONE', sortMode: 'NONE', tagFilter: '*', type: 'GitParameterDefinition'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://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@github.com/vikalatosh/SauceDemoProject-master.git'

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true -Dbrowser=%BROWSER% -Dheadless=%HEADLESS% clean package"
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
    }
}