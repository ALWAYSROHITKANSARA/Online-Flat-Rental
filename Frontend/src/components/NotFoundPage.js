import React from 'react';
import { Router } from 'react-router';
import { Link } from 'react-router-dom';


function NotFoundPage() {

   return (
      <React.Fragment>
        <div class="page-wrap d-flex flex-row align-items-center c2">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12 text-center">
                <span class="display-1 d-block">404</span>
                <div class="mb-4 lead">The page you are looking for was not found.</div>
                <a href="/" class="btn btn-outline-secondary">Back to Home</a>
            </div>
        </div>
    </div>
</div>

      
      </React.Fragment>
    );
}

export default NotFoundPage;