pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/Gersongmax/entrega5.git'

                // Run Maven on a Unix agent.
                sh "cd meu-app; mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/meu-app/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'meu-app/target/*.jar'
                }
            }
        }
    }
}
