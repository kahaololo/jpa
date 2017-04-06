module.exports = function (grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        clean: {
            build: {
                src: ['./build']
            }
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'js/main.js',
                dest: 'build/main.min.js'
            }
        },
        riot: {
            options: {
                type: 'es6'
            },
            dist: {
                expand: true,
                cwd: 'app',
                src: '**/*',
                dest: 'build/app',
                ext: '.js',
                filter: 'isFile'
            }
        },
        copy: {
            css: {
                src: 'css/*.css',
                dest: 'build/',
            },
            lib_css: {
                src: 'node_modules/bootstrap/dist/css/bootstrap.min.css',
                dest: 'build/css/lib/',
                expand: true,
                flatten: true,
                filter: 'isFile'
            },
            img: {
                src: 'img/*.png',
                dest: 'build/',
            },
            js: {
                src: ['js/routes.js'],
                dest: 'build/',
            },
            lib: {
                src: [
                    "node_modules/riot/riot.js",
                    "node_modules/riot-route/dist/route.js",
                    "node_modules/jquery/dist/jquery.min.js",
                    "node_modules/bootstrap/dist/js/bootstrap.min.js",
                    "node_modules/bootstrap-notify/bootstrap-notify.js",
                    "node_modules/moment/moment.js",
                    "node_modules/highcharts/highcharts.js",
                    "node_modules/material-design-lite/material.min.js",
                ],
                dest: 'build/lib/',
                expand: true,
                flatten: true,
                filter: 'isFile'
            },
            build: {
                files: [
                    {
                        src: 'build/**',
                        dest: '../webapp/',
                    },
                    {
                        src: 'index.html',
                        dest: '../webapp/'
                    }
                ]
            }
        },
        connect: {
            server: {
                options: {
                    port: 3000,
                    base: 'build',
                    keepalive: true
                }
            }
        }
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-connect');
    grunt.loadNpmTasks('grunt-riot');

    // Default task(s).
    grunt.registerTask('default', ['clean', 'riot', 'copy']);

};