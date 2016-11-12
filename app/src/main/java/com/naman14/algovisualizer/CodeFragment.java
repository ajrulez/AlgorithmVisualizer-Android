package com.naman14.algovisualizer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naman14.algovisualizer.algorithm.Algorithm;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

/**
 * Created by naman on 03/06/16.
 */
public class CodeFragment extends Fragment {

    CodeView codeView;

    public static CodeFragment newInstance(String algorithm) {
        CodeFragment fragment = new CodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Algorithm.KEY_ALGORITHM, algorithm);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_code, container, false);

        codeView = (CodeView) rootView.findViewById(R.id.code_view);
        codeView.setTheme(CodeViewTheme.GITHUB);
        setCode(getArguments().getString(Algorithm.KEY_ALGORITHM));

        return rootView;
    }

    public void setCode(String key) {
        if (codeView!=null) {
            switch (key) {
                case Algorithm.BUBBLE_SORT:
                    codeView.showCode(AlgorithmCode.CODE_BUBBLE_SORT);
                    break;
                case Algorithm.INSERTION_SORT:
                    codeView.showCode(AlgorithmCode.CODE_INSERTION_SORT);
                    break;
            }
        }
    }
}
