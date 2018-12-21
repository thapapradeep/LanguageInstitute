 <head>
 <!-- Bootstrap core CSS-->
<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${pageContext.request.contextPath}/css/sb-admin.css" rel="stylesheet">

</head>
 <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.html">Language Institute</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

    

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
        
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          >
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="**/logout" data-toggle="modal" data-target="#logoutModal">Logout</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/manager">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
          </a>
        </li>
        
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="RolesDropdoen" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Role</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
            
            <a class="dropdown-item" href="/manager/viewRoles">View Role</a>
            
          </div>
        </li>
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="StaffsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Staff</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
            
            <a class="dropdown-item" href="/manager/viewStaffs">View Staff</a>
            
          </div>
          </li>
    
        
     
        
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="teachersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Teachers</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="teachersDropdown">
            
            
            <a class="dropdown-item" href="manager/teachers">View Teachers</a>
            
            
          </div>
        </li>
        
           <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="teachersDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Languages</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="teachersDropdown">
            
            <a class="dropdown-item" href="manager/addLanguage">Add Language</a>
            <a class="dropdown-item" href="manager/viewLangauages">View Language</a>
            
          </div>
        </li>
        
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Students</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
           
            <a class="dropdown-item" href="manager/students">View Students</a>
            
          </div>
        </li>
        
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Class Management</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
            <a class="dropdown-item" href="manager/addClasses">Add Class</a>
            <a class="dropdown-item" href="manager/viewClasses">View Class</a>
            
          </div>
        </li>
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Batch</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
            <a class="dropdown-item" href="manager/addBatch">Add Batch</a>
            <a class="dropdown-item" href="manager/viewBatch">View Batch</a>
            
          </div>
        </li>
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Class Routine</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
            <a class="dropdown-item" href="manager/createRoutine">Add Routine</a>
            <a class="dropdown-item" href="manager/viewRoutine">View Routine</a>
            
          </div>
        </li>
         <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Transaction</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
           
            <a class="dropdown-item" href="manager/viewTransaction">View transaction</a>
            
          </div>
        </li>
            <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="studentsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-folder"></i>
            <span>Reports</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="studentsDropdown">
            
           
            <a class="dropdown-item" href="manager/viewAvgBalance">View Student Per Class</a>
            <a class="dropdown-item" href="manager/viewIncome">View Income Report</a>
             <a class="dropdown-item" href="manager/viewExpense">View Expense Reports</a> 
          </div>
        </li>
       
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

        

         