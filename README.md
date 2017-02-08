# HorizontalScrollviewDemo
横向和竖向都能滑动控件，横向使用HorizontalScrollview，竖向使用ListView

---主要在Adapter中，ListView添加的是LinearLayout(Horizontal)，然后在每个LinearLayout(Horizontal)添加宽度权重一样的子元素

public class MyListAdapter extends BaseAdapter {

    private Context mContext ;
    private List<ItemBean> mDataLists ;
    private int mColumnNum = 0 ;
    private int mRowNum = 0 ;

    public MyListAdapter() {
    }

    /**
     *  构造函数
     * @param mContext
     * @param mDataLists
     */
    public MyListAdapter(Context mContext, List<ItemBean> mDataLists , int columnNum ) {
        this.mContext = mContext;
        this.mDataLists = mDataLists;
        this.mColumnNum = columnNum ;
    }

    @Override
    public int getCount() {
        return mDataLists.size();
    }

    @Override
    public ItemBean getItem(int i) {
        return mDataLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(mContext).inflate(R.layout.list_row_layout,null);

        LinearLayout row = (LinearLayout) view.findViewById(R.id.listViewRow);  // 行布局
        if(row != null) row.removeAllViews(); // 清空行
        for (int i = 0; i < mColumnNum ; i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item,null);
            TextView itemNameTv = (TextView) itemView.findViewById(R.id.itemNameTv);
            TextView itemLocationTv = (TextView) itemView.findViewById(R.id.itemLocationTv);

            ItemBean itemBean = getLocationBean(position+1 , i+1); // 获取对应的实体类
            if(itemBean != null){
                itemNameTv.setText(itemBean.getPictureName());
                itemLocationTv.setText(itemBean.getId());
                // 添加到行布局中去
                row.addView(itemView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            }
        }
        return view;  // 返回加载好了内容的行布局
    }

    /***
     *  根据座位号获取对应的元素
     * @param row
     * @param column
     * @return
     */
    private ItemBean getLocationBean(int row , int column){
        String index = column+"-"+row; // 生成索引，对比索引找到对应的学生
        for (int i = 0; i < this.getCount(); i++) {
            if(this.getItem(i).getId().equals(index))
                return this.getItem(i) ;
        }
        return null ;
    }
}
