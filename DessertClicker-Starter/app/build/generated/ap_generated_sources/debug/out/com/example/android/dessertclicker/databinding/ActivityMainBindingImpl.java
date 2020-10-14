package com.example.android.dessertclicker.databinding;
import com.example.android.dessertclicker.R;
import com.example.android.dessertclicker.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.background_image, 3);
        sViewsWithIds.put(R.id.margin_end_guide, 4);
        sViewsWithIds.put(R.id.margin_bottom_guide, 5);
        sViewsWithIds.put(R.id.margin_start_guide, 6);
        sViewsWithIds.put(R.id.dessert_button, 7);
        sViewsWithIds.put(R.id.white_background, 8);
        sViewsWithIds.put(R.id.dessert_sold_text, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (androidx.constraintlayout.widget.Guideline) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[4]
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.view.View) bindings[8]
            );
        this.amountSoldText.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.revenueText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.amountSold == variableId) {
            setAmountSold((java.lang.Integer) variable);
        }
        else if (BR.revenue == variableId) {
            setRevenue((java.lang.Integer) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAmountSold(@Nullable java.lang.Integer AmountSold) {
        this.mAmountSold = AmountSold;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.amountSold);
        super.requestRebind();
    }
    public void setRevenue(@Nullable java.lang.Integer Revenue) {
        this.mRevenue = Revenue;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.revenue);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.Integer amountSold = mAmountSold;
        java.lang.String revenueToString = null;
        java.lang.String javaLangStringRevenueToString = null;
        java.lang.String amountSoldToString = null;
        java.lang.Integer revenue = mRevenue;

        if ((dirtyFlags & 0x5L) != 0) {



                if (amountSold != null) {
                    // read amountSold.toString()
                    amountSoldToString = amountSold.toString();
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (revenue != null) {
                    // read revenue.toString()
                    revenueToString = revenue.toString();
                }


                // read ("$") + (revenue.toString())
                javaLangStringRevenueToString = ("$") + (revenueToString);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.amountSoldText, amountSoldToString);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.revenueText, javaLangStringRevenueToString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): amountSold
        flag 1 (0x2L): revenue
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}