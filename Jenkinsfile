pipeline{
    agent any
    stages{
        
        stage("Build"){
            steps{
                echo("building the projrct")
            }
        }
         stage("Run UAT"){
            steps{
                echo("run the uat test cases ")
            }
        }
        
        stage("Deploy on dev"){
            steps{
                echo("Deploy on dev")
            }
        }
        
        stage("Deploy on QA"){
            steps{
                echo("Deploy on QA")
            }
        }
        stage("Sanity test cases on QA"){
            steps{
                echo("Sanity test cases on QA")
            }
        }
        
         stage("Regression test cases on QA"){
            steps{
                echo("Regression test cases on QA")
            }
        }
        
         stage("deploy on stage"){
            steps{
                echo("deploy on stage")
            }
        }
         stage("Sanity test cases on stage"){
            steps{
                echo("Sanity test cases on stage")
            }
        }
          stage("deploy on Prod"){
            steps{
                echo("deploy on Prod")
            }
        }
        
    }
}