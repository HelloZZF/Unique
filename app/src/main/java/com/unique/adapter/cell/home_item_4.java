package com.unique.adapter.cell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.unique.R;
import com.unique.adapter.base.RVBaseAdapter;
import com.unique.adapter.base.RVBaseCell;
import com.unique.adapter.base.RVBaseViewHolder;
import com.unique.adapter.base.RVSimpleAdapter;
import com.unique.adapter.item4_adapter;
import com.unique.bean.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.WeakHashMap;

/**
 * Created by zzf on 2018/5/14.
 */
public class home_item_4 extends RVBaseCell {

    private List<Work> mWorkList = new ArrayList<>();
    private Context mContext;

    public home_item_4(Context context) {
        super(null);
        mContext = context;
    }

    @Override
    public int getItemType() {
        return 4;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType, RVBaseAdapter.OnItemClickListener listener) {

        initData();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_4, parent, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new item4_adapter(mWorkList));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        return new RVBaseViewHolder(view, listener);
    }

    private void initData() {

        Work work1 = new Work("作品:幽灵鸟", "作者:贝贝", "点击鼠标或者手机屏幕就可以！一个考验操作的小游戏，看看谁能拿到最高分吧！", R.drawable.item4_7);
        mWorkList.add(work1);

        Work work2 = new Work("作品:分类闯关", "作者:LM", "让大家简单的认识垃圾分类以及处理方式，点击小树还有接垃圾游戏哟~希望大家喜欢", R.drawable.item4_2);
        mWorkList.add(work2);

        Work work3 = new Work("作品:是忍者就下100层", "作者:哆啦A梦", "用键盘左右来帮助忍者度过难关吧\n" + "小心有些平台是对你造成伤害的\n" + "要合理分配生命哦！", R.drawable.item4_3);
        mWorkList.add(work3);

        Work work4 = new Work("作品:打擂台", "作者:Time", "经过我多次计算和调试\n" + "有可能会有BUG\n" + "当赞超过50，我就更新\n" + "记得点赞哦", R.drawable.item4_4);
        mWorkList.add(work4);

        Work work5 = new Work("作品:找到小土豆", "作者:浔、", "小土豆变成狗了，快找到他吧！", R.drawable.item4_5);
        mWorkList.add(work5);

        Work work6 = new Work("作品:神秘猎人", "作者:M78星云", "在神秘世界扮演神秘猎人，一起来冒险吧！喜欢我的作品吗？点个赞再走吧！", R.drawable.item4_6);
        mWorkList.add(work6);

        Work work7 = new Work("作品:物理俄罗斯", "作者:Mine7", "Mine7原创作品“物理俄罗斯”在传统游戏的基础上，利用物理引擎再添创意你一定会喜欢上的", R.drawable.item4_1);
        mWorkList.add(work7);

        Work work8 = new Work("作品:桌上冰球", "作者:吐司", "双人桌上冰球游戏。\n" + "将球击入对方底线便得一份，冰球速度会逐渐加快。\n" + "鼠标控制红方移动，\n" + "左右方向键控制蓝方移动", R.drawable.item4_8);
        mWorkList.add(work8);

        Work work9 = new Work("作品:打BOSS", "作者:喵子", "用上下左右键来操作你的英雄，去闯关，后续会更新更有难度的关卡，觉的好玩请大家点个赞！", R.drawable.item4_9);
        mWorkList.add(work9);

        Work work10 = new Work("作品:马里奥", "作者:西瓜太郎", "花了一个月编写的黑豹战队马里奥的飞行之旅，这次的马里奥成为了一名飞行员，快来体验不一样的世界吧！", R.drawable.item4_10);
        mWorkList.add(work10);

        Work work11 = new Work("作品:八音符", "作者:小假", "这次我们不再鬼哭狼嚎了,改用点击屏幕控制八分酱移动啦!\n" + "点击并蓄力,避开白色部位,跳到黑色部位", R.drawable.item4_11);
        mWorkList.add(work11);

        Work work12 = new Work("作品:贪吃蛇", "作者:Mine7", "贪吃蛇4.1.1正式版发布！优化初始长度转盘", R.drawable.item4_12);
        mWorkList.add(work12);

        Work work13 = new Work("作品:时钟射手", "作者:栗子L", "时钟转转转，时钟转转转，快来让快乐的时钟转起来吧！", R.drawable.item4_13);
        mWorkList.add(work13);

        Work work14 = new Work("作品:炮塔大闯关", "作者:SHOT", "1.点击'开始',按回车,开始游戏\n" + "2.移动发射器，它会自动发射；\n" + "3. 30分进入第二关，50分进入第三关，120分游戏成功；", R.drawable.item4_14);
        mWorkList.add(work14);

        Work work15 = new Work("作品:踢足球", "作者:香蕉Boy", "点箭头或按下上下左右 控制方向，不用被对方球员拦住。一个月后更新，多多点赞。", R.drawable.item4_15);
        mWorkList.add(work15);

        Work work16 = new Work("作品:涂鸦跳跃", "作者:阿呆", "经典游戏涂鸦跳跃大家应该都玩过吧\\n\" + \"这只永远不甘失败的小犰狳又又又又开始了他永不\\n\" + \"停止的攀登了", R.drawable.item4_16);
        mWorkList.add(work16);

        Work work17 = new Work("作品:猫老祖", "作者:creeper", "小鸟大战猫老祖的终极版本 的更新版制作中\\n\" + \"预告：增加小鸟的3个技能\\n\" + \"猫老祖回血 ‘\\n\" + \"更机智的AI", R.drawable.item4_17);
        mWorkList.add(work17);

        Work work18 = new Work("作品:晚霞农场", "作者:晚霞", "这是一个类似QQ农场的游戏。\n" + "费尽我一个晚上的功夫才做成该游戏的原型。（没有半点停顿，还一直整到凌晨）后来还经过了我的多次润色才算成功。", R.drawable.item4_18);
        mWorkList.add(work18);

        Work work19 = new Work("作品:机器人", "作者:默默", "角色点击编程猫跟着鼠标移动，但不能离开跑道，同时要躲避火球的攻击哦！试试能坚持几秒吧~", R.drawable.item4_19);
        mWorkList.add(work19);

        Work work20 = new Work("作品:猜成语", "作者:笔墨", "更新：画质、素材大更新，画风与旧版截然不同，在墨笔飘香的环境下感受中国文化之美吧！", R.drawable.item4_20);
        mWorkList.add(work20);


    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {


    }
}
