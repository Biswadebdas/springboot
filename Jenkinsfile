pipeline {
  agent any
  stages {
     stage('Build') {
         steps {
         echo 'Build complete'
         }
     }
      stage('Test') {
         steps {
         echo 'Test complete'
         }
     }
      stage('Deploy') {
         steps {
         echo 'Deploy complete'
         }
     }
  }
  post{
   always
   {
     emailext body: 'Summary' , subject: 'Pipeline Status' , to:'biswadeb.das@nagarro.com'
   }
  }
  
}
