/*
Camping project
Computer Graphics

Done by:

Name:               Group:
Lama Bugis          3      
Mawadah Alghuraybi  3
Abeer Tunkar        3
Ghada Alsharif      5
Maryam Almalki      5
Haneen Alkurbi      5
*/


#include <GL\glew.h> 
#include <GL\freeglut.h> 
#include <stdlib.h>
#include <iostream>
#include <conio.h>
#include <GL/glut.h>
#include <math.h>
#include <GLFW/glfw3.h>
#include <cmath>
#include<Windows.h>
#include<mmsystem.h>

using namespace std;

const int NUM_POINTS = 360;
const int NUM_COPIES = 1;

float cloud_move = 0, cloud_move2 = 0, cloud_move3 = 0;
float red = 0.78, green = 0.93, blue = 1;
float skyR = 1, skyG = 1, skyB = 1;
float moonMove = 0.0, sunMove = 0.0;

int sunStatus, moonStatus;


void drawStars() {

    glBegin(GL_TRIANGLES);

    glColor3f(1, 1, 0);
    glVertex3f(-0.60, 0.77, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.42, 0.77, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.58, 0.68, 0);

    //second triangle top triangle

    glColor3f(1, 1, 0);
    glVertex3f(-0.64, 1, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.68, 0.77, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.60, 0.77, 0);

    //3rd Triangle
    glColor3f(1, 1, 0);
    glVertex3f(-0.68, 0.77, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.7, 0.68, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.86, 0.77, 0);

    //4th Triangle
    glColor3f(1, 1, 1);
    glVertex3f(-0.64, 0.63, 0);

    glColor3f(1, 1, 0);
    glVertex3f(-0.7, 0.68, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.82, 0.43, 0);

    //5th Triangle
    glColor3f(1, 1, 1);
    glVertex3f(-0.64, 0.63, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.58, 0.68, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.51, 0.43, 0);

    glEnd();

    glBegin(GL_POLYGON);//code for the Polygon within the stars
    glColor3f(1, 1, 1);//sets color of Polygon

    glVertex3f(-0.68, 0.77, 0); //set the 5 vetices of polygon

    glColor3f(1, 1, 1);
    glVertex3f(-0.60, 0.77, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.7, 0.68, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.64, 0.63, 0);

    glColor3f(1, 1, 1);
    glVertex3f(-0.58, 0.68, 0);




    glEnd();


}

void DrawPoints() {
    glBegin(GL_POINTS);
    glColor3f(1, 1, 0);
    glVertex2f(0.2, 0.4);
    glEnd();
}

void DisplayStars() {

    if (sunMove < -0.1) {
        DrawPoints();
        glPushMatrix();
        glTranslatef(0.6, 0.5, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.15) {
        glPushMatrix();
        glTranslatef(-0.4, 0.5, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.2) {
        glPushMatrix();
        glTranslatef(-0.2, 0.7, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.25) {
        glPushMatrix();
        glTranslatef(0, 0.85, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.3) {
        glPushMatrix();
        glTranslatef(-0.345, 0.68, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.35) {
        glPushMatrix();
        glTranslatef(-0.6, 0.8, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.35) {
        glPushMatrix();
        glTranslatef(-0.1, 0.5, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.4) {
        glPushMatrix();
        glTranslatef(0.15, 0.6, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.45) {
        glPushMatrix();
        glTranslatef(-.8, 0.55, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.45) {
        glPushMatrix();
        glTranslatef(0.10, 0.7, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

    if (sunMove < -0.5) {
        glPushMatrix();
        glTranslatef(0.4, 0.49, 0);
        glScalef(0.09, 0.09, 0);
        drawStars();
        glPopMatrix();
    }

}

void DrawCircle(float cx, float cy, float r, int num_segments)
{
    glBegin(GL_POLYGON);
    for (int i = 0; i < num_segments; i++)
    {
        glVertex2f(
            cx + (r * cos(2 * 3.14 * i / num_segments)),
            cy + (r * sin(2 * 3.14 * i / num_segments))
        );
    }
    glEnd();
}

void sun()
{
    glPushMatrix();
    glColor3f(30., 1.0, 0.5);
    DrawCircle(.55, .82, 0.12, 102);
    glPopMatrix();
}

void drawSun()
{
    glPushMatrix();
    glScalef(1, 1, 0);
    glTranslatef(0, sunMove, 0);
    sun();
    glPopMatrix();
    if (sunStatus == 1) {
        DisplayStars();
        sunMove -= 0.00003;
        if (sunMove < -0.6)
            sunMove = -0.6;
    }
}

void moon()
{
    glPushMatrix();
    glColor3f(1, 1, 1);
    DrawCircle(.55, .82, 0.12, 102);
    glPopMatrix();
}

void drawMoon()
{
    glPushMatrix();
    glScalef(0.5, 0.5, 0);
    glTranslatef(0, moonMove, 0);
    moon();
    glPopMatrix();
    if (moonStatus == 1) {
        moonMove += 0.00003;
        if (moonMove > 0.9) {
            moonMove = 0.9;
        }
    }
}

void cloud()
{
    if (sunStatus == 1) {
        if (skyR > 0.4) {
            skyR -= 0.000005;
            skyG -= 0.000005;
            skyB -= 0.000005;
        }

        glColor3f(skyR, skyG, skyB);

        DrawCircle(.625, .58, .06, 100); //1st cloud
        DrawCircle(.7, .6, .09, 100);
        DrawCircle(.79, 0.582, .07, 100);
        DrawCircle(.85, 58, .05, 100);

        DrawCircle(-0.425, 0.585, 0.05, 100); //2st cloud
        DrawCircle(-0.5, 0.6, 0.08, 100);
        DrawCircle(-0.59, 0.592, 0.06, 100);
        DrawCircle(-0.64, 0.58, 0.04, 100);
    }
    else {
        glColor3f(skyR, skyG, skyB);

        DrawCircle(.625, .58, .06, 100); //1st cloud
        DrawCircle(.7, .6, .09, 100);
        DrawCircle(.79, 0.582, .07, 100);
        DrawCircle(.85, 58, .05, 100);

        DrawCircle(-0.425, 0.585, 0.05, 100); //2st cloud
        DrawCircle(-0.5, 0.6, 0.08, 100);
        DrawCircle(-0.59, 0.592, 0.06, 100);
        DrawCircle(-0.64, 0.58, 0.04, 100);
    }
}

void drawCloud()
{
    glPushMatrix();
    glTranslatef(cloud_move, 0.0, 0.0);
    cloud();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(cloud_move2, 0.1, 0.0);
    cloud();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(cloud_move3, 0.2, 0.0);
    cloud();
    glPopMatrix();


    cloud_move += 0.000085; {
        if (cloud_move > 1.9) {
            cloud_move = -1.0;
        }
    }

    cloud_move2 += 0.00008; {
        if (cloud_move2 > 1.0) {
            cloud_move2 = -1.7;
        }
    }

    cloud_move3 += 0.00009; {
        if (cloud_move3 > 1.0) {
            cloud_move3 = -1.7;
        }
    }
}

void sky()
{
    if (sunStatus == 1)
    {
        if (green > 0.1804)
            green -= 0.000035;
        if (red > 0.02353)
            red -= 0.000035;
        if (blue > 0.3451)
            blue -= 0.000035;
        glEnable(GL_BLEND);
        glBegin(GL_POLYGON);
        glColor3f(red, green, blue);
        glVertex3f(-1, 1, 0.0); // bottom left
        glVertex3f(-1, -0.25, 0.0); //bottom right
        glVertex3f(1, 1, 0.0); // top right
        glVertex3f(1, -0.25, 0.0); // top left
        glEnd();
        glDisable(GL_BLEND);
    }
}

void stump()
{
    glBegin(GL_TRIANGLES);

    glVertex2f(-0.05f, 0.0f);
    glVertex2f(0.05f, 0.0f);
    glVertex2f(0.0f, 1.0f);
    glEnd();
}

void leaves()
{
    glBegin(GL_TRIANGLES);

    glVertex2f(-0.2f, 0.8f);
    glVertex2f(0.2f, 0.8f);
    glVertex2f(0.0f, 1.05f);
    glEnd();
}

void tree()
{
    glPushMatrix();
    glTranslatef(0.0, 0.0, 0.0);
    glColor3f(0.4353f, 0.27f, 0.0f);
    stump();
    glPopMatrix();


    glPushMatrix();
    glTranslatef(0.0, -1.05, 0.0);
    glScalef(1.9, 1.6, 1.0);
    glColor3f(0.3137f, 0.50588f, 0.26666f);
    leaves();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.0, -0.7, 0.0);
    glScalef(1.6, 1.4, 1.0);
    glColor3f(0.3137f, 0.6117f, 0.26666f);
    leaves();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.0, -0.35, 0.0);
    glScalef(1.3, 1.2, 1.0);
    glColor3f(0.3137f, 0.7019f, 0.2666f);
    leaves();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.0, 0.0, 0.0);
    glColor3f(0.3843f, 0.8235f, 0.3137f);
    leaves();
    glPopMatrix();

}

void drawTree()
{
    glPushMatrix();
    glTranslatef(-0.2, -0.4, 0);
    glScalef(0.6, 0.7, 1);
    tree();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.65, -0.75, 0);
    glScalef(0.9, 1, 1);
    tree();
    glPopMatrix();


    glPushMatrix();
    glTranslatef(0.2, -0.3, 0);
    glScalef(0.4, 0.4, 1);
    tree();
    glPopMatrix();
}

void drawMountain() {
    glMatrixMode(GL_MODELVIEW);
    glPushMatrix();

    gluOrtho2D(-3, 3, -3, 3);

    glScalef(0.7, 0.8, 1);
    glTranslatef(1.2, 1, 0);
    glBegin(GL_TRIANGLES);

    glColor3f(0.91, 0.76, 0.65); //brown color
    glVertex2f(-3, -2);  //bottom left point of the triangle
    glVertex2f(2.3, 1.4);  //top point of the triangle
    glVertex2f(4, -2);  //bottom right point of the triangle


    glColor3f(0.54, 0.37, 0.26); //brown color
    glVertex2f(-3, -2);  //bottom left point of the triangle
    glVertex2f(0, 1);  //top point of the triangle
    glVertex2f(5, -2);

    glEnd();
    glPopMatrix();
}

void drawMountain2() {

    glMatrixMode(GL_MODELVIEW);
    glPushMatrix();

    gluOrtho2D(-2, 1, -1.6, 1);
    glTranslatef(-0.4, -0.05, 0);
    glScalef(0.3, 0.3, 1);
    glBegin(GL_TRIANGLES);

    glColor3f(0.6, 0.4, 0.28); //brown color
    glVertex2f(-8, -2);  //bottom left point of the triangle
    glVertex2f(-4, 2);  //top point of the triangle
    glVertex2f(4, -2);

    glColor3f(0.5, 0.3, 0.18); //brown color
    glVertex2f(-5, -2);  //bottom left point of the triangle
    glVertex2f(-1, 1.4);  //top point of the triangle
    glVertex2f(4, -2);  //bottom right point of the triangle

    glEnd();
    glPopMatrix();
}

void camp()
{
    glTranslatef(-0.3, 0, 0);
    glBegin(GL_QUADS);

    glColor3f(0.309804, 0.309804, 0.184314);
    glVertex2f(-0.7, -0.7);

    glColor3f(1.0, 1.0, 1.0);
    glVertex2f(-0.5, 0.5);

    glColor3f(0.309804, 0.309804, 0.184314);
    glVertex2f(0.5, 0.5);

    glColor3f(0.309804, 0.309804, 0.184314);
    glVertex2f(0.5, -0.8);
    glEnd();


    glTranslatef(-0, 0, 0);
    glBegin(GL_TRIANGLES);

    glColor3f(0.10, 0.10, 0.10);
    glVertex2f(0.5, -0.74);

    glColor3f(0.10, 0.10, 0.10);
    glVertex2f(0.9, -0.72);

    glColor3f(0.20, 0.20, 0.20);
    glVertex2f(0.5, 0.5);

    glEnd();
}

void drawPin()
{
    glBegin(GL_POLYGON);

    glColor3f(0.5, 0.5, 0.5);
    glVertex2f(-0.001, -0.001);
    glVertex2f(-0.04, 0.04);
    glVertex2f(0.04, 0.04);
    glVertex2f(0.001, -0.001);
    glEnd();
}

void drawLines()
{
    glLineWidth(1.5);
    glBegin(GL_LINES);

    glColor3f(1, 1, 1);
    glVertex2f(-0.85, -0.82);
    glVertex2f(-0.6, 0.4);

    glVertex2f(0.1, -0.89);
    glVertex2f(0.35, 0.4);

    glVertex2f(0.85, -0.82);
    glVertex2f(0.4, 0.4);

    glEnd();
}

void cmapTogether()
{
    glPushMatrix();
    glRotatef(360, 0, 0, 1.0);
    glTranslatef(0.2, -0.1, 0);
    camp();
    glPopMatrix();

    glPushMatrix();
    drawLines();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.10, -0.93, 0);
    drawPin();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.85, -0.83, 0);
    drawPin();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.89, -0.85, 0);
    drawPin();
    glPopMatrix();
}

void drawCamp()
{
    glPushMatrix();
    glScalef(-0.45, 0.45, 1);
    glTranslatef(-1.2, -0.6, 0);
    cmapTogether();
    glPopMatrix();
}

void firewood() {
    glColor3f(0.6, 0.4, 0.2); //Set the color to brown for the firewood
    glLineWidth(15);

    //Draw the firewood
    glBegin(GL_LINES);

    glVertex2f(0.01, -0.9);
    glVertex2f(-0.06, -0.4);
    glVertex2f(-0.06, -0.4);
    glVertex2f(-0.06, -0.4);

    glEnd();
}

void grass() {
    glEnable(GL_BLEND);
    glBegin(GL_POLYGON);
    glColor4f(0.5, 1.0, 0.5, 0.5);
    glVertex2f(7.0, -1.0);
    glColor4f(0.5, 1.0, 0.5, 0.3);
    glVertex2f(3.0, 0);
    glColor4f(0.5, 1.0, 0.5, 0.1);
    glVertex2f(-3.0, -0.3);
    glColor4f(0.5, 0.1, 0.5, 0.8);
    glVertex2f(3.0, -3.0);
    glEnd();
    glDisable(GL_BLEND);
}

void ellipse(float cx, float cy, float rx, float ry, int num_segments) {
    float theta = 2 * 3.1415926 / float(num_segments);
    float c = cosf(theta);
    float s = sinf(theta);
    float t;

    float x = 1;
    float y = 0;

    glBegin(GL_TRIANGLE_FAN);
    for (int i = 0; i < num_segments; i++)
    {
        glVertex2f(x * rx + cx, y * ry + cy);
        t = x;
        x = c * x - s * y;
        y = s * t + c * y;
    }
    glEnd();
}

void flower() {
    glLineWidth(3.0f);
    glBegin(GL_LINES);
    glColor3f(0.0, 0.4, 0.3);
    glVertex2f(0.0f, -0.2f);
    glVertex2f(0.0f, 0.3f);
    glEnd();

    glPushMatrix();
    glColor3f(0.0, 0.4, 0.3);
    glRotatef(45, 0, 0, 1);
    glTranslatef(-0.2, 0.0, 0);
    ellipse(0.0, 0.0, 0.1, 0.3, 40);
    glRotatef(90, 0, 0, 1);
    glTranslatef(-0.2, -0.2, 0);
    ellipse(0.0, 0.0, 0.1, 0.3, 40);
    glPopMatrix();

    glPushMatrix();
    glColor3f(0.9, 0.7, 0.7);
    ellipse(0.0, 0.4, 0.2, 0.3, 40);
    glColor3f(0.9, 0.7, 0.7);
    ellipse(0.0, 0.4, 0.3, 0.2, 40);
    glPopMatrix();
}

void fire()
{
    gluOrtho2D(-0.9, 0.9, -0.9, 0.9);
    glClear(GL_COLOR_BUFFER_BIT);

    // Grass
    glPushMatrix();
    glTranslatef(-1.3, 1.5, 0);
    glScalef(1.999, 1.24, 0);
    grass();
    glPopMatrix();

    //flowers
    glPushMatrix();
    glRotatef(180, 0, 0, 1.0);
    glScalef(0.2, 0.2, 0.0);
    glTranslatef(-0.3, 0.5, 0);
    flower();
    glPopMatrix();

    glPushMatrix();
    glRotatef(180, 0, 0, 1.0);
    glScalef(0.2, 0.2, 0.0);
    glTranslatef(-3.5, -2.0, 0);
    flower();
    glPopMatrix();

    glPushMatrix();
    glRotatef(180, 0, 0, 1.0);
    glScalef(0.2, 0.2, 0.0);
    glTranslatef(3.5, -3.2, 0);
    flower();
    glPopMatrix();

    // Fire
    for (int j = 0; j < NUM_COPIES; j++) {
        glColor3f(1.0f, 0.3, 0);
        glBegin(GL_TRIANGLE_FAN);
        glVertex2f(j * 0.5, 0.0);
        for (int i = 0; i <= NUM_POINTS; i++)
        {
            float angle = 2.0 * 3.14 * i / NUM_POINTS;
            glVertex2f(j * 0.5 + 0.26 * cos(angle), 0.20 * sin(angle) + 0.5);

        }
        glEnd();

    }

    glBegin(GL_TRIANGLES);
    glColor3f(1.0f, 0.3, 0);
    glVertex3f(0.15f, 0.1f, 0.0f);
    glVertex3f(0.2f, 0.4f, 0.0f);
    glVertex3f(-0.1f, 0.4f, 0.0f);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0f, 0.3, 0);
    glVertex3f(0.25f, 0.3f, 0.0f);
    glVertex3f(0.23f, 0.6f, 0.0f);
    glVertex3f(-0.1f, 0.6f, 0.0f);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0f, 0.3, 0);
    glVertex3f(-0.15f, 0.1f, 0.0f);
    glVertex3f(-0.2f, 0.4f, 0.0f);
    glVertex3f(0.1f, 0.4f, 0.0f);
    glEnd();

    glBegin(GL_TRIANGLES);
    glColor3f(1.0f, 0.3, 0);
    glVertex3f(-0.25f, 0.3f, 0.0f);
    glVertex3f(-0.23f, 0.6f, 0.0f);
    glVertex3f(0.1f, 0.6f, 0.0f);
    glEnd();
}

void firePoints()
{
    glPointSize(3.0f); // Draw points

    glBegin(GL_POINTS);
    glColor3f(1.f, 0.75f, 0.0f);

    for (int i = 0; i < 3; i++) {
        float x = static_cast <float> (rand()) / static_cast <float> (RAND_MAX);
        float y = static_cast <float> (rand()) / static_cast <float> (RAND_MAX);
        glVertex2f(x, y);
    }
    glEnd();
}

void drawGround()
{
    glPushMatrix();
    glScalef(0.5, 0.5, 1);
    glRotatef(180, 0, 0, -1);
    glTranslatef(0.1, 1, 0);
    fire();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(-0.25, -0.85, 0.0);
    glScalef(0.4, 0.3, 0);
    firePoints();
    glPopMatrix();
}

void drawWood()
{
    glPushMatrix();
    glRotatef(80, 0, 0, -1);
    glTranslatef(0.9, 0.5, 0);
    firewood();
    glPopMatrix();

    glPushMatrix();
    glRotatef(120, 0, 0, -1);
    glTranslatef(0.9, 1.0, 0);
    firewood();
    glPopMatrix();

    glPushMatrix();
    glRotatef(105, 0, 0, -1);
    glTranslatef(0.9, 0.9, 0);
    firewood();
    glPopMatrix();

    glPushMatrix();
    glRotatef(110, 0, 0, -1);
    glTranslatef(0.9, 0.9, 0);
    firewood();
    glPopMatrix();

    glPushMatrix();
    glTranslatef(0.55, -0.2, 0);
    glScaled(-0.40, 0.43, 0);
    glPopMatrix();
}

void keyBoard(unsigned char key, int x, int y) {
    switch (key) {
    case 's': // sun move
        sunStatus = 1;
        break;
    case 'm': // moon move
        moonStatus = 1;
        break;
    default:
        break;
    }
}

void init() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    glClearColor(red, green, blue, 0);
}

static void play(void)
{
    glutPostRedisplay();
}

void displayAll()
{
    // fire
    drawGround();

    // Sky
    sky();

    // Sun
    drawSun();

    // Moon
    drawMoon();

    // Mountains
    drawMountain();
    drawMountain2();

    // Trees
    drawTree();

    // Firewood
    drawWood();

    //camp
    drawCamp();

    // Clouds
    drawCloud();

    glutSwapBuffers();
}

int main(int argc, char** argv)
{

    glutInit(&argc, argv);                                              // Initialize GLUT
    glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH);   //  Specify the display
    glutInitWindowSize(700, 600);                                   // Set the window's initial width & height
    glutInitWindowPosition(50, 50);                                  // Position the window's initial top-left corner
    glutCreateWindow("Camping");                                 // Create a window with the given title
    glutKeyboardFunc(keyBoard);
    init();
    glutIdleFunc(play);
    PlaySound(TEXT("voice.wav"), NULL, SND_ASYNC);
    glutDisplayFunc(displayAll);

    glutMainLoop();                   // Enter the infinitely event-processing loop

    return 0;
}