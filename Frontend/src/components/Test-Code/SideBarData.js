import React from 'react';

export const SideBarData = [
    {
        title:'User',
        path:'/',
        subNav:[
            {
                title:'Add User',
                path:'/user/adduser',
            },
            {
                title:'Update User',
                path:'/user/updateuser',
            },
            {
                title:'Remove User',
                path:'/user/removeuser',
            },
            {
                title:'View User',
                path:'/user/viewuser',
            },
            {
                title:'View All User',
                path:'/user/viewalluser',
            },
        ]
    },
    {
        title:'Booking',
        path:'/booking',
        subNav:[
            {
                title:'Add Booking',
                path:'/booking/addbooking',
            },
            {
                title:'Update Booking',
                path:'/booking/updateupdatebooking',
            },
            {
                title:'Remove Booking',
                path:'/booking/removebooking',
            },
            {
                title:'View Booking',
                path:'/booking/viewbooking',
            },
            {
                title:'View All Booking',
                path:'/booking/viewallbooking',
            },
        ]
    }
    
]