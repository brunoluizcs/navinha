package com.bomcodigo.navinha.game.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;

import com.bomcodigo.navinha.game.Assets;
import com.bomcodigo.navinha.game.control.Button;
import com.bomcodigo.navinha.game.interfaces.ButtonDelegate;
import com.bomcodigo.navinha.game.screens.ScreenBackground;

import static com.bomcodigo.navinha.game.DeviceSettings.screenHeight;
import static com.bomcodigo.navinha.game.DeviceSettings.screenResolution;
import static com.bomcodigo.navinha.game.DeviceSettings.screenWidth;

public class GameOverScreen extends CCLayer implements ButtonDelegate {
    private ScreenBackground background;
    private Button beginButton;

    public CCScene scene(){
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }

    public GameOverScreen() {
        this.background = new ScreenBackground(Assets.BACKGROUND1);
        this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth()/2.0f,screenHeight() / 2.0f)));
        this.addChild(this.background);

        CCSprite title = CCSprite.sprite(Assets.GAMEOVER);
        title.setPosition(CGPoint.ccp(screenWidth()/2,screenHeight()-130));
        //this.addChild(title);

        this.setIsTouchEnabled(true);
        this.beginButton = new Button(Assets.PLAY);
        this.beginButton.setPosition(screenResolution(CGPoint.ccp(screenWidth()/2,screenHeight()-250)));
        this.beginButton.setDelegate(this);
        addChild(this.beginButton);
    }

    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.beginButton)){
            SoundEngine.sharedEngine().pauseSound();
            CCDirector.sharedDirector().replaceScene(new TitleScreen().scene());
        }
    }
}
